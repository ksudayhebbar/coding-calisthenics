package com.app.builder.pat;

public class FullName {
	private final String lastString;
	private final String firstString;
	private final String middleString;
	private final String salutation;
	private final String suffix;

	private FullName(final String newLastString, final String newFirstString,
			final String newMiddleString, final String newSalutation,
			final String newSuffix) {
		this.lastString = newLastString;
		this.firstString = newFirstString;
		this.middleString = newMiddleString;
		this.salutation = newSalutation;
		this.suffix = newSuffix;
	}

	public String getLastString() {
		return this.lastString;
	}

	public String getFirstString() {
		return this.firstString;
	}

	public String getMiddleString() {
		return this.middleString;
	}

	public String getSalutation() {
		return this.salutation;
	}

	public String getSuffix() {
		return this.suffix;
	}

	@Override
	public String toString() {
		return this.salutation + " " + this.firstString + " "
				+ this.middleString + this.lastString + ", " + this.suffix;
	}

	public static class FullNameBuilder {
		private final String nestedLastString;
		private final String nestedFirstString;
		private String nestedMiddleString;
		private String nestedSalutation;
		private String nestedSuffix;

		public FullNameBuilder(final String newLastString,
				final String newFirstString) {
			this.nestedLastString = newLastString;
			this.nestedFirstString = newFirstString;
		}

		public FullNameBuilder middleString(final String newMiddleString) {
			this.nestedMiddleString = newMiddleString;
			return this;
		}

		public FullNameBuilder salutation(final String newSalutation) {
			this.nestedSalutation = newSalutation;
			return this;
		}

		public FullNameBuilder suffix(final String newSuffix) {
			this.nestedSuffix = newSuffix;
			return this;
		}

		public FullName createFullName() {
			return new FullName(nestedLastString, nestedFirstString,
					nestedMiddleString, nestedSalutation, nestedSuffix);
		}
	}

	public static void main(String[] args) {
		FullName fn = new FullNameBuilder("Uday", "Hebarr").middleString(
				"Kumar").createFullName();
		System.out.println(fn);

	}
}
