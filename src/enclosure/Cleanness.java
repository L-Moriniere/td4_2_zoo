package enclosure;

public enum Cleanness {
	BAD{
		public String toString() {
			return "\033[0;31m" + "Invivable" + "\u001B[0m";
		}
	},
	CORRECT{
		public String toString() {
			return "\033[0;33m" + "Sali" + "\u001B[0m";
		}
	},
	GOOD{
		public String toString() {
			return "\033[0;32m" + "Bon" + "\u001B[0m";
		}
	};
}
