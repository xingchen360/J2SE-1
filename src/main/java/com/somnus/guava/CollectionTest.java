/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.somnus.guava;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;

/**
 * @ClassName: IterablesTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Somnus
 * @date 2018年9月27日
 */
public class CollectionTest {
	
	@Test
	public void Iterables() {
		Iterable<Integer> concatenated = Iterables.concat(
				  Ints.asList(1, 2, 3),
				  Ints.asList(4, 5, 6));
		concatenated.forEach(item -> System.out.println(item));
		
		System.out.println(Iterables.getLast(concatenated));
		System.out.println(Iterables.getFirst(concatenated,99));
	}
	
	@Test
	public void Lists() {
		List<String> list = Lists.newArrayList();
		list.forEach(System.out::println);
		
		List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
		countUp.forEach(System.out::println);
		
		List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
		countDown.forEach(System.out::println);
		
		List<List<Integer>> parts = Lists.partition(countUp, 2); // {{1, 2}, {3, 4}, {5}}
		parts.forEach(System.out::println);
	}
	
	@Test
	public void Sets() {
		Set<String> set1st = Sets.newHashSet();
		Set<String> set2nd = Sets.newLinkedHashSet();
		Set<String> set3rd = Sets.newTreeSet();
		set1st.forEach(System.out::println);
		set2nd.forEach(System.out::println);
		set3rd.forEach(System.out::println);
		
		Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
		primes.forEach(System.out::println);
	}
	
	@Test
	public void Maps() {
		Map<String, Integer> map = Maps.newHashMap();
		map.forEach((k,v) -> {
			System.out.println(k);
		});
		
		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
		MapDifference<String, Integer> diff = Maps.difference(left, right);

		diff.entriesInCommon(); // {"b" => 2}
		diff.entriesDiffering(); // {"c" => (3, 4)}
		diff.entriesOnlyOnLeft(); // {"a" => 1}
		diff.entriesOnlyOnRight(); // {"d" => 5}
	}
}
