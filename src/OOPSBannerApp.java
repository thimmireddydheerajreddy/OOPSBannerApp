/*
*OOPSBannerApp UC7
*
*@author Dheeraj 
*@version 7.0
*/

public class OOPSBannerApp {

    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        charMaps[0] = new CharacterPatternMap('O', new String[]{
            "   ***   " ,
            " **   ** " ,
            " **   ** " ,
            " **   ** " ,
            " **   ** " ,
            " **   ** " ,
            "   ***   "
        });

        charMaps[1] = new CharacterPatternMap('P', new String[]{
            " ******   " ,
            " **    ** " ,
            " **    ** " ,
            " ******   " ,
            " **       " ,
            " **       " ,
            " **       " 
        });

        charMaps[2] = new CharacterPatternMap('S', new String[]{
            "   *****     " ,
            "  **    **   " ,
            " **          " ,
            "   *****     " ,
            "         **  " ,
            " **     **   " ,
            "   *****     " 
        });

        charMaps[3] = new CharacterPatternMap(' ', new String[]{
            "    ",
            "    ",
            "    ",
            "    ",
            "    ",
            "    ",
            "    "
        });

        return charMaps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == Character.toUpperCase(ch)) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int lines = 7;

        for (int i = 0; i < lines; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                sb.append(pattern[i]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}