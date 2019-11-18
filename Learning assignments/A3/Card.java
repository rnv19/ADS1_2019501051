    public class Card{
        String suit;
        String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        } 

        public int compareTo(Card card) {
            int thisvalue = 0;
            int thatvalue = 0;
            if (this.suit.equals("S")) { thisvalue = 1;}
            else if (this.suit.equals("H")) { thisvalue = 2;}
            else if (this.suit.equals("C")) { thisvalue = 3;}
            else if (this.suit.equals("D")) { thisvalue = 4;}
            if (card.suit.equals("S")) { thatvalue = 1;}
            else if (card.suit.equals("H")) { thatvalue = 2;}
            else if (card.suit.equals("C")) { thatvalue = 3;}
            else if (card.suit.equals("D")) { thatvalue = 4;}

            if (thisvalue < thatvalue) return -1;
            if (thisvalue > thatvalue) return 1;
            if (thisvalue == thatvalue) {
                int thisfacevalue = 0;
                int thatfacevalue = 0;
                if (this.rank.equals("A")) { thisfacevalue = 1;}
                else if (this.rank.equals("J")) { thisfacevalue = 11;}
                else if (this.rank.equals("Q")) { thisfacevalue = 12;}
                else if (this.rank.equals("K")) { thisfacevalue = 13;}
                else {thisfacevalue = Integer.parseInt(this.rank);}
                
                if (card.rank.equals("A")) { thatfacevalue = 1;}
                else if (card.rank.equals("J")) { thatfacevalue = 11;}
                else if (card.rank.equals("Q")) { thatfacevalue = 12;}
                else if (card.rank.equals("K")) { thatfacevalue = 13;}
                else {thatfacevalue = Integer.parseInt(card.rank);}

                if (thisfacevalue < thatfacevalue) return -1;
                if (thisfacevalue > thatfacevalue) return 1;
                else return 0;
            }
            return 0;
        }

        public String toString() {
            return suit + "-" + rank;
        }

    }