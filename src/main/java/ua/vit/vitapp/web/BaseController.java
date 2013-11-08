package ua.vit.vitapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class BaseController {
	
	class Tag {
		public int id;
		public String tagName;
	 
		//getter and setter methods
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTagName() {
			return tagName;
		}

		public void setTagName(String tagName) {
			this.tagName = tagName;
		}
		public Tag(int id, String tagName) {
			this.id = id;
			this.tagName = tagName;
		}
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		//model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
		System.out.println("Inside welcome");
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}
 
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Tag> getTags(@RequestParam String requestString) {
		System.out.println("Requesting Ajax for " + requestString);
		return simulateSearchResult(requestString);
	}
	
	private List<Tag> simulateSearchResult(String tagName) {
		List<Tag> data = new ArrayList<Tag>();
		data.add(new Tag(1, "Yuriy Bukhtiiarov"));
		data.add(new Tag(2, "Yuriy Vuntesmeri"));
		data.add(new Tag(3, "Yuriy Aksenov"));
		data.add(new Tag(4, "Igor Orlov"));
		data.add(new Tag(5, "Tatiana Bukhtiiarova"));
		data.add(new Tag(6, "Olga Demchenko"));
		data.add(new Tag(7, "Sergey Bondar"));
		data.add(new Tag(8, "Olga Malinina"));
		
		List<Tag> result = new ArrayList<Tag>();
 
		// iterate a list and filter by tagName
		for (Tag entry : data) {
			if (entry.getTagName().contains(tagName)) {
				result.add(entry);
			}
		}
		return result;
	}
}