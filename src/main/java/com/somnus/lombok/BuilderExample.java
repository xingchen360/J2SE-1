/**
 * <p>Title: BuilderExample.java </p>
 * <p>Description: TODO(用一句话描述该文件做什么) </p>
 *
 * @author pc
 * @version 1.0.0
 * @date 2018年9月21日
 */
package com.somnus.lombok;

import java.util.Set;

import lombok.Builder;
import lombok.Singular;

/**
 * @ClassName: BuilderExample
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pc
 * @date 2018年9月21日
 */
@Builder
public class BuilderExample {
	@Builder.Default
	private long created = System.currentTimeMillis();

	private String name;

	private int age;

	@Singular
	private Set<String> occupations;

	public static void main(String[] args) {
		System.out.println(BuilderExample.builder().build().created);
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<String> getOccupations() {
		return occupations;
	}

	public void setOccupations(Set<String> occupations) {
		this.occupations = occupations;
	}

}
