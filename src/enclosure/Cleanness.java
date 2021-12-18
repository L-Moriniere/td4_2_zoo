package enclosure;

public enum Cleanness {
	BAD{
		public String toString() {
			return "\033[0;31m" + "Bad" + "\u001B[0m";
		}
	},
	CORRECT{
		public String toString() {
			return "\033[0;33m" + "Correct" + "\u001B[0m";
		}
	},
	GOOD{
		public String toString() {
			return "\033[0;32m" + "Good" + "\u001B[0m";
		}
	};
}
