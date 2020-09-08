package blog.main.dao;

import java.util.List;

import blog.main.entity.Tag;

public interface TagDAO {

	
	public List<Tag> getTagList();
	
	public List<Tag> getSevenMostUsedTags();
	
	public Tag getTag(int id);
	
	public void saveTag(Tag tag);
	
	public void deleteTag(int id);
	
	public List<Tag> getListOfMostFrequentlyUsedTags();
	
	public List<Tag> getTagsById(List<Integer> ids);	
}
