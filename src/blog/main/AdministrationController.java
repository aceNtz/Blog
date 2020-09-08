package blog.main;


import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogPostDAO;
import blog.main.dao.BloggerDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.CommentDAO;
import blog.main.dao.CompanyDAO;
import blog.main.dao.FrontTextDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SliderElementDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.BlogPost;
import blog.main.entity.Blogger;
import blog.main.entity.Category;
import blog.main.entity.ChangePassword;
import blog.main.entity.Comment;
import blog.main.entity.Company;
import blog.main.entity.FrontText;
import blog.main.entity.Message;
import blog.main.entity.SliderElement;
import blog.main.entity.Tag;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

	@Autowired
	private SliderElementDAO sliderElementDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private BloggerDAO bloggerDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private TagDAO tagDAO;
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private BlogPostDAO blogPostDAO;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private FrontTextDAO frontTextDAO;
	

	
	
	
	
	
	// Metoda koja sa admin panela vodi na index stranu
	@RequestMapping("/front-index")
	public String getIndexPage() {
		return "redirect:/index-page";
	}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------INFO------------------------------------------------------ //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/company-info")
	public String getCompanyInfoPage(Model model, Principal principal) {
		model.addAttribute("company", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "company-info-page";
	}
	
	
	@RequestMapping("/company-info-update")
	public String updateCompanyInfo(Model model, Principal principal) {
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("company", companyDAO.getCompanyInfo());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "company-info-update-page";
	}
	
	
	@RequestMapping("/company-info-save")
	public String saveCompanyInfo(@ModelAttribute Company company) {
		companyDAO.saveCompanyInfo(company);
		
		return "redirect:/administration/company-info";
	}
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------FRONT TEXT-------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/front-text")
	public String getFrontTextPage(Model model, Principal principal) {
		model.addAttribute("frontText", frontTextDAO.getFrontText());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		
		return "front-text-page";
	}
	
	
	@RequestMapping("/front-text-update")
	public String updateFrontText(Model model, Principal principal) {
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("frontText", frontTextDAO.getFrontText());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "front-text-update-page";
	}
	
	
	@RequestMapping("/front-text-save")
	public String saveFrontText(@ModelAttribute FrontText frontText) {
		frontTextDAO.updateFrontText(frontText);
		
		return "redirect:/administration/front-text";
	}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------SLAJDER--------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/slider-element-list")
	public String getSliderList(Model model, Principal principal) {
		model.addAttribute("sliderElementList", sliderElementDAO.getSliderElementList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		
		return "slider-element-list-page";
	}
	
	@RequestMapping("/slider-element-form")
	public String addSliderElement(Model model, Principal principal) {
		SliderElement slederElement = new SliderElement();
		model.addAttribute("sliderElement", slederElement);
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "slider-element-form-page";
	}
	
	@RequestMapping("/slider-element-save")
	public String saveSliderElement(@Valid @ModelAttribute SliderElement sliderElement, BindingResult result) {
		if(result.hasErrors()) {
			return "slider-element-form-page";
		}
		
		sliderElementDAO.saveSliderElement(sliderElement);

		return "redirect:/administration/slider-element-list";
	}
	
	@RequestMapping("/slider-element-update")
	public String updateSliderElement(@RequestParam int id, Model model, Principal principal){
		SliderElement element = sliderElementDAO.getSliderElement(id);
		model.addAttribute("sliderElement", element);
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "slider-element-form-page";
	}
	
	@RequestMapping("/slider-element-delete")
	public String deleteSliderElement(@RequestParam int id) {
		sliderElementDAO.deleteSliderElement(id);
		
		return "redirect:/administration/slider-element-list";
	}
	
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------ //
	// ---------------------------------------------------PORUKE--------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------ //
	
	
	@RequestMapping("/message-list")
	public String getMessageList(Model model, Principal principal) {
		model.addAttribute("messageList", messageDAO.getMessageList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "message-list-page";
	}
	
	@RequestMapping("/message-unread-list")
	public String getMessageUnreadList(Model model, Principal principal) {
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("messageUnreadList", messageDAO.getUnreadMessageList());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "message-unread-list-page";
	}
	
	@RequestMapping("/message-seen-update")
	public String updateSeenMessage(@RequestParam int id,@RequestParam int pageId) {
		Message message = messageDAO.getMessage(id);
		
		message.setSeen(!message.getSeen());
		
		messageDAO.saveMessage(message);
		
		// Sluzi za vracanje na stranu sa koje je poslat request
		if(pageId == 1) {
			return "redirect:/administration/message-list";
		}
		else {
			return "redirect:/administration/message-unread-list";
		}
	}
	
	@RequestMapping("/message-delete")
	public String deleteMessage(@RequestParam int id) {
		messageDAO.deleteMessage(id);
		return "redirect:/administration/message-list";
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------BLOGERI--------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/blogger-list")
	public String getBloggerList(Model model, Principal principal) {
		model.addAttribute("bloggerList", bloggerDAO.getBloggerList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		
		
		return "blogger-list-page";
	}
	
	@RequestMapping("/blogger-banned-list")
	public String getBloggerBannedList(Model model, Principal principal) {
		model.addAttribute("bannedBloggers", bloggerDAO.getBannedBloggerList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blogger-banned-list-page";
	}
	
	@RequestMapping("/blogger-form")
	public String addBlogger(Model model, Principal principal) {
		Blogger blogger = new Blogger();
		model.addAttribute("blogger", blogger);
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("roles", bloggerDAO.getRoles());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blogger-form-page";
	}
	
	@RequestMapping("/blogger-save")
	public String saveBlogger(@ModelAttribute Blogger blogger, Model model) {
		
		String passwordEncode = new BCryptPasswordEncoder().encode(blogger.getPassword());
		blogger.setPassword("{bcrypt}"+passwordEncode);
		
		
		bloggerDAO.saveBlogger(blogger);
		
		return "redirect:/administration/blogger-list";
	}
	
	@RequestMapping("/blogger-ban")
	public String banBlogger(@RequestParam String username) {
		bloggerDAO.banUnbanBlogger(username);
		
		return "redirect:/administration/blogger-list";
	}
	
	@RequestMapping("/blogger-unban")
	public String unbanBlogger(@RequestParam String username) {
		bloggerDAO.banUnbanBlogger(username);
		
		return "redirect:/administration/blogger-banned-list";
	}
	
	
	
	@RequestMapping("/blogger-profile")
	public String getBloggerProfile(Model model, Principal principal) {
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("blogger", bloggerDAO.getBlogger(principal.getName()));
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blogger-profile-page";
	}
	
	@RequestMapping("/blogger-profile-save")
    public String saveProfileInfo(@ModelAttribute Blogger blogger) {
		bloggerDAO.saveBlogger(blogger);
		
		return "redirect:/administration/";
	}
	
	
	@RequestMapping("/blogger-change-password")
	public String changePassword(Model model) {
		model.addAttribute("changePassword", new ChangePassword());
		
		
		return "blogger-password-change-page";
	}
	
	
	@RequestMapping("/change-password-action")
	public String newPasswordCheck(Model model, Principal principal, @ModelAttribute ChangePassword changePassword) {
		if(changePassword.getNewPassword().equalsIgnoreCase(changePassword.getConfirmPassword())) {
			Blogger blogger = bloggerDAO.getBlogger(principal.getName());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if(encoder.matches(changePassword.getOldPassword(), blogger.getPassword().replace("{bcrypt}", ""))) {
				blogger.setPassword("{bcrypt}"+encoder.encode(changePassword.getNewPassword()));
				bloggerDAO.saveBlogger(blogger);
			}
			
			else {
				return "blogger-password-change-page";
			}
			
		}
		
		else {
			return "blogger-password-change-page";
		}
		
		return "redirect:/administration/";
	}
	
	
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------KATEGORIJE------------------------------------------------ //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/category-list")
	public String getCategoryList(Model model, Principal principal) {
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "category-list-page";
	}
	
	@RequestMapping("category-form")
	public String addCategory(Model model, Principal principal) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "category-form-page";
	}
	
	@RequestMapping("/category-save")
	public String saveCategory(@Valid @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category-form-page";
		}
		categoryDAO.saveCategory(category);
		
		return "redirect:/administration/category-list";
	}
	
	@RequestMapping("/category-update")
	public String updateCategory(@RequestParam int id, Model model, Principal principal) {
		model.addAttribute("category", categoryDAO.getCategory(id));
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "category-form-page";
	}
	
	@RequestMapping("/category-delete")
	public String deleteCategory(@RequestParam int id) {
		categoryDAO.deleteCategory(id);
		
		return "redirect:/administration/category-list";
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// ---------------------------------------------------TAGOVI---------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	
	@RequestMapping("/tag-list")
	public String getTagList(Model model, Principal principal) {
		model.addAttribute("tagList", tagDAO.getTagList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "tag-list-page";
	}
	
	
	@RequestMapping("tag-form")
	public String addTag(Model model, Principal principal) {
		Tag tag = new Tag();
		model.addAttribute("tag", tag);
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "tag-form-page";
	}
	
	@RequestMapping("/tag-save")
	public String saveTag(@Valid @ModelAttribute Tag tag, BindingResult result) {
		if(result.hasErrors()) {
			return "tag-form-page";
		}
		
		// Stavljamo '#' i menjamo string toLowerCase radi konstantnosti
		if(tag.getName().charAt(0) != '#') {
			String tagNameWithHashtag = '#' + tag.getName();;
			tag.setName(tagNameWithHashtag.toLowerCase());
		}
		
		tagDAO.saveTag(tag);
		
		return "redirect:/administration/tag-list";
	}
	
	
	@RequestMapping("/tag-delete")
	public String deleteTag(@RequestParam int id) {
		tagDAO.deleteTag(id);
		
		return "redirect:/administration/tag-list";
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// --------------------------------------------------KOMENTARI-------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	@RequestMapping("/comment-list")
	public String getCommentList(Model model, Principal principal) {
		model.addAttribute("commentList", commentDAO.getCommentList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "comment-list-page";
	}
	
	@RequestMapping("/comment-visible-update")
	public String updateCommentVisibility(@RequestParam int id) {
		Comment comment = commentDAO.getComment(id);
		
		if(comment.getVisible() == false) {
			comment.setVisible(true);
		}
		else {
			comment.setVisible(false);
		}
		commentDAO.saveComment(comment);
		
		return "redirect:/administration/comment-list";
	}
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------- //
	// -------------------------------------------------BLOG-POST--------------------------------------------------- //
	// ------------------------------------------------------------------------------------------------------------- //
	
	
	
	
	@RequestMapping("/blog-post-list")
	public String getBlogPostList(Model model, Principal principal) {
		model.addAttribute("blogPostList", blogPostDAO.getBlogPostList());
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blog-post-list-page";
	}
	
	
	@RequestMapping({"/blog-post-my-list", "/"})
	public String getMyBlogPostList(Model model, Principal principal) {
		model.addAttribute("blogPostList", blogPostDAO.getMyBlogPostList(principal));
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blog-post-my-list-page";
	}
	
	
	@RequestMapping("/blog-post-form")
	public String createBlogPost(Model model, Principal principal) {
		BlogPost bp = new BlogPost();
		
		model.addAttribute("blogPost", bp);
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("tagList", tagDAO.getTagList());
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));

		
		return "blog-post-form-page";
	}
	
	
	@RequestMapping("/blog-post-update")
	public String updateBlogPost(@RequestParam int id, Model model, Principal principal) {
		
		model.addAttribute("blogPost", blogPostDAO.getBlogPostWithTagsAndComments(id));
		model.addAttribute("unreadCounter", messageDAO.getUnreadMessageList().size());
		model.addAttribute("tagList", tagDAO.getTagList());
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("user", bloggerDAO.getBlogger(principal.getName()));
		
		return "blog-post-form-page";
	}
	
	@RequestMapping("/blog-post-important-update")
	public String updateImportantBlogPost(@RequestParam int id) {
		blogPostDAO.updateImportantBlogPost(id);
		
		return "redirect:/administration/blog-post-list";
	}
	
	
	@RequestMapping("/blog-post-save")
	public String saveBlogPost(@ModelAttribute BlogPost blogPost, Principal principal) {
		System.out.println(1);
		// Setujemo autora
		Blogger author = bloggerDAO.getBlogger(principal.getName());
		blogPost.setAuthor(author);
		
		//TODO Proveriti da li radi
		// Povecavamo broj koriscenja izabrane kategorije za +1
		blogPost.getCategory().setTimesUsed(blogPost.getCategory().getTimesUsed() + 1);
		
		// Parsiramo tagove
		List<Integer> ids = new ArrayList<Integer>();
		for(Tag tag : blogPost.getTags()) {
			ids.add(Integer.parseInt(tag.getName()));
			
			//TODO proveriti da li radi
			// Dodajemo +1 za broj koriscenja Taga
			tag.setTimesUsed(tag.getTimesUsed() + 1);
		}
		List<Tag> tags = tagDAO.getTagsById(ids);
		
		blogPost.setTags(tags);
		blogPostDAO.saveBlogPost(blogPost);
	
		return "redirect:/administration/blog-post-my-list";
	}
	
	
	@RequestMapping("/blog-post-delete")
	public String deleteBlogPost(@RequestParam int id, @RequestParam int pageId) {
		blogPostDAO.deleteBlogPost(id);
		
		if(pageId == 1) {
			return "redirect:/administration/blog-post-list";
		}
		else {
			return "redirect:/administration/blog-post-my-list";
		}
			
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
