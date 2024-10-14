package Task6;

import java.util.HashMap;

class Character {
    private char value;
    private String font;
    private int size;

    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    public void display(int positionX, int positionY) {
        System.out.println("Character: " + value + " at (" + positionX + ", " + positionY + ") with font " + font + " and size " + size);
    }
}

class CharacterFactory {
    private HashMap<String, Character> characterMap = new HashMap<>();

    public Character getCharacter(char value, String font, int size) {
        String key = value + font + size;
        if (!characterMap.containsKey(key)) {
            characterMap.put(key, new Character(value, font, size));
        }
        return characterMap.get(key);
    }
}

class TextEditor {
    private CharacterFactory characterFactory;
    private java.util.List<Character> characters = new java.util.ArrayList<>();

    public TextEditor(CharacterFactory factory) {
        this.characterFactory = factory;
    }

    public void insertText(String text, String font, int size) {
        for (char c : text.toCharArray()) {
            characters.add(characterFactory.getCharacter(c, font, size));
        }
    }

    public void renderText() {
        int positionX = 0;
        int positionY = 0;
        for (Character character : characters) {
            character.display(positionX, positionY);
            positionX += 10;
        }
    }
}

class TextEditorApp {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        TextEditor editor = new TextEditor(factory);
        editor.insertText("Hello World", "Arial", 12);
        editor.renderText();
    }
}
