package net.sandfur.util;

import java.util.Stack;
import java.util.regex.Pattern;

public class Patternize {
	StringBuilder buildPattern = new StringBuilder();
	
	Stack<String> group = new Stack<String>();

	public Patternize() {
	}
	
	public Patternize add(String pattern) {
		buildPattern.append(pattern);
		return this;
	}
	public Patternize addQutoed(String pattern) {
		return add(Pattern.quote(pattern));
	}
	
	public Patternize addGroup(String pattern) {
		group.push(")");
		return add("(").add(pattern);
	}

	public Patternize addNamedGroup(String pattern, String name) {
		return addGroup(String.format("?<%s>%s", name, pattern));
	}
	
	public Patternize closeGroup() {
		return add(group.pop());
	}
	
	public String toString() {
		while(group.size() > 0) {
			add(group.pop());
		}
		return buildPattern.toString();
	}
}
