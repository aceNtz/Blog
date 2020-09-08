package blog.main;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogPostDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.CompanyDAO;
import blog.main.dao.FrontTextDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SliderElementDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.BlogPost;
import blog.main.entity.Message;
import blog.main.entity.Tag;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private SliderElementDAO sliderElementDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private TagDAO tagDAO;
	@Autowired
	private BlogPostDAO blogPostDAO;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private FrontTextDAO frontTextDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	

	
	
	@RequestMapping({"/","/index-page"})
	public String getIndexPage(Model model) throws ParseException {
		List<BlogPost> recentBP = blogPostDAO.getTwelweRecentBlogPosts();
		List<BlogPost> importantBP = blogPostDAO.getThreeImportantBlogsForIndexPage();
		List <BlogPost> footerBP = blogPostDAO.getThreeRecentBlogPosts();
		

		LocalDate dateToday = LocalDate.now();
		
		for(BlogPost bp : recentBP) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bp.getDate().toString());
			bp.setDateOptionOne(new SimpleDateFormat("dd MMMM | yyyy").format(date));
		}
		
		for(BlogPost bp : importantBP) {
			bp.setDateOptionOne(Period.between(bp.getDate(), dateToday).getMonths() + " months ago");		
		}
		
		for(BlogPost bp : footerBP) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bp.getDate().toString());
			bp.setDateOptionOne(new SimpleDateFormat("MMMM dd, yyyy").format(date));
		}
		
		model.addAttribute("sliderElementList", sliderElementDAO.getSliderElementListForIndexPage());
		model.addAttribute("importantBP", importantBP);
		model.addAttribute("recentBP", recentBP);
		model.addAttribute("footerBP", footerBP);
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("frontText", frontTextDAO.getFrontText());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/index-page";
	}
	
	@RequestMapping("/contact-page")
	public String getContactPage(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/contact-page";
	}
	
	@RequestMapping("/blog-page")
	public String getBlogPage(Model model, @RequestParam(defaultValue = "0") int pageNum) throws ParseException {
		List<BlogPost> allEnabledBlogPosts = blogPostDAO.getAllEnabledBlogPosts();
		
		LocalDate dateToday = LocalDate.now();
		
		for(BlogPost bp : allEnabledBlogPosts) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bp.getDate().toString());
			bp.setDateOptionOne(new SimpleDateFormat("dd MMMM | yyyy").format(date));
		}
		
		for(BlogPost bp : allEnabledBlogPosts) {
			bp.setDateOptionTwo(Period.between(bp.getDate(), dateToday).getMonths() + " months ago");		
		}
		
		
		int numOfPages; 
		if(allEnabledBlogPosts.size() % 12 == 0) {
			numOfPages = allEnabledBlogPosts.size() / 12;
		}
		else {
			numOfPages = allEnabledBlogPosts.size() / 12 + 1;
		}
		
		
		ArrayList<BlogPost> list = new ArrayList<BlogPost>();
		
		for(int i = 0; i < 12; i++ ) {
			if(allEnabledBlogPosts.size() > pageNum * 12 + i) {
				list.add(allEnabledBlogPosts.get(pageNum * 12 + i));
			}
			else {
				break;
			}
		}
		
		
		
		model.addAttribute("allEnabledBlogPosts", list);
		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("mostUsedTags", tagDAO.getSevenMostUsedTags());
		model.addAttribute("mostUsedCategories", categoryDAO.getFiveMostUsedCategories());
		model.addAttribute("threeMostViewedBlogPostsFromLastThirtyDays", blogPostDAO.getThreeMostViewedBlogPostsFromLast30Days());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		model.addAttribute("numberOfPages", numOfPages);
		model.addAttribute("pageNum",  pageNum);
	
		
		return "front/blog-page";
	}
	
	@RequestMapping("/blog-post-page")
	public String getBlogPostPage(Model model, @RequestParam int id) throws ParseException {
		LocalDate dateToday = LocalDate.now();
		BlogPost bp = blogPostDAO.getBlogPost(id);
		
		bp.setDateOptionOne(Period.between(bp.getDate(), dateToday).getMonths() + " months ago");	
		
		model.addAttribute("blogPost", bp);
		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		model.addAttribute("mostUsedTags", tagDAO.getSevenMostUsedTags());
		model.addAttribute("mostUsedCategories", categoryDAO.getFiveMostUsedCategories());
		model.addAttribute("threeMostViewedBlogPostsFromLastThirtyDays", blogPostDAO.getThreeMostViewedBlogPostsFromLast30Days());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/blog-post-page";
	}
	
	@RequestMapping("/blog-author-page")
	public String getBlogAuthorPage(Model model) {

		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/blog-author-page";
	}
	
	@RequestMapping("/blog-category-page")
	public String getBlogCategoryPage(Model model) {

		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/blog-category-page";
	}
	
	@RequestMapping("/blog-tag-page")
	public String getBlogTagPage(Model model) {

		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		
		return "front/blog-tag-page";
	}
	
	@RequestMapping("/blog-search-page")
	public String getBlogSearchPage(Model model) {

		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("importantCategories", categoryDAO.getFourImportantCategories());
		
		return "front/blog-search-page";
	}
	
	
	// ------------------------------------------------------------------------------------------------------------------
	
	
	@RequestMapping("/message-save")
	public String messageSave(@Valid @ModelAttribute Message message, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "front/contact-page";
		}
		messageDAO.saveMessage(message);
		
		

		model.addAttribute("sliderElementList", sliderElementDAO.getSliderElementListForIndexPage());
		model.addAttribute("importantBP", blogPostDAO.getThreeImportantBlogsForIndexPage());
		model.addAttribute("recentBP", blogPostDAO.getTwelweRecentBlogPosts());
		model.addAttribute("footerBP", blogPostDAO.getThreeRecentBlogPosts());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("frontText", frontTextDAO.getFrontText());
		// Saljemo konfirmaciju na index stranu da je poruka uspesno poslata
		model.addAttribute("messageSentConfirmation", true);
		
		return "front/index-page";
	}
	
	
	
}
