package blog.main.dao;

import java.util.List;

import blog.main.entity.SliderElement;

public interface SliderElementDAO {
	
	public SliderElement getSliderElement(int id);

	public List<SliderElement> getSliderElementList();
	
	public List<SliderElement> getSliderElementListForIndexPage();
	
	public void saveSliderElement(SliderElement sliderElement);
	
	public void deleteSliderElement(int id);
	
	
}
