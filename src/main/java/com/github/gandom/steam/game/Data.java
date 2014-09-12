package com.github.gandom.steam.game;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	private String about_the_game;
	private Achievements achievements;
	private List<Categories> categories;
	private String controller_support;
	private String detailed_description;
	private List<?> developers;
	private List<?> dlc;
	private String drm_notice;
	private List<Genres> genres;
	private String header_image;
	private Metacritic metacritic;
	private String name;
	private Platforms platforms;
	private Price_overview price_overview;
	private List<?> publishers;
	private Release_date release_date;
	private Number required_age;
	private String reviews;
	private List<Screenshots> screenshots;
	private Number steam_appid;
	private Support_info support_info;
	private String supported_languages;
	private String type;
	private String website;
	private String legal_notice;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getAbout_the_game() {
		return this.about_the_game;
	}

	public void setAbout_the_game(String about_the_game) {
		this.about_the_game = about_the_game;
	}

	public Achievements getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}

	public List<Categories> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public String getDetailed_description() {
		return this.detailed_description;
	}

	public void setDetailed_description(String detailed_description) {
		this.detailed_description = detailed_description;
	}

	public List<?> getDevelopers() {
		return this.developers;
	}

	public void setDevelopers(List<?> developers) {
		this.developers = developers;
	}

	public List<?> getDlc() {
		return this.dlc;
	}

	public void setDlc(List<?> dlc) {
		this.dlc = dlc;
	}

	public String getDrm_notice() {
		return this.drm_notice;
	}

	public void setDrm_notice(String drm_notice) {
		this.drm_notice = drm_notice;
	}

	public List<Genres> getGenres() {
		return this.genres;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	public String getHeader_image() {
		return this.header_image;
	}

	public void setHeader_image(String header_image) {
		this.header_image = header_image;
	}

	public Metacritic getMetacritic() {
		return this.metacritic;
	}

	public void setMetacritic(Metacritic metacritic) {
		this.metacritic = metacritic;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Platforms getPlatforms() {
		return this.platforms;
	}

	public void setPlatforms(Platforms platforms) {
		this.platforms = platforms;
	}

	public Price_overview getPrice_overview() {
		return this.price_overview;
	}

	public void setPrice_overview(Price_overview price_overview) {
		this.price_overview = price_overview;
	}

	public List<?> getPublishers() {
		return this.publishers;
	}

	public void setPublishers(List<?> publishers) {
		this.publishers = publishers;
	}
	
	public Release_date getRelease_date() {
		return this.release_date;
	}

	public void setRelease_date(Release_date release_date) {
		this.release_date = release_date;
	}

	public Number getRequired_age() {
		return this.required_age;
	}

	public void setRequired_age(Number required_age) {
		this.required_age = required_age;
	}

	public String getReviews() {
		return this.reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public List<?> getScreenshots() {
		return this.screenshots;
	}

	public void setScreenshots(List<Screenshots> screenshots) {
		this.screenshots = screenshots;
	}

	public Number getSteam_appid() {
		return this.steam_appid;
	}

	public void setSteam_appid(Number steam_appid) {
		this.steam_appid = steam_appid;
	}

	public Support_info getSupport_info() {
		return this.support_info;
	}

	public void setSupport_info(Support_info support_info) {
		this.support_info = support_info;
	}

	public String getSupported_languages() {
		return this.supported_languages;
	}

	public void setSupported_languages(String supported_languages) {
		this.supported_languages = supported_languages;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getController_support() {
		return controller_support;
	}

	public void setController_support(String controller_support) {
		this.controller_support = controller_support;
	}

	public String getLegal_notice() {
		return legal_notice;
	}

	public void setLegal_notice(String legal_notice) {
		this.legal_notice = legal_notice;
	}
}
