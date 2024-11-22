/**
 * https://t.me/zhukovsd_it_chat/53243/144102
 */
package views;

import java.util.List;

public class HangmanPictures {
    private static final List<List<String>> PICTURES = List.of(
            List.of(
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        "
            ),
            List.of(
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "+======+"
            ),
            List.of(
                    "       +",
                    "       |",
                    "       |",
                    "       |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "       |",
                    "       |",
                    "       |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "       |",
                    "       |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "       |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /    |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|   |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|\\  |",
                    "       |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|\\  |",
                    "  /    |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|\\  |",
                    "  / \\  |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|\\  |",
                    " _/ \\  |",
                    "+======+"
            ),
            List.of(
                    "   +---+",
                    "   |   |",
                    "   o   |",
                    "  /|\\  |",
                    " _/ \\_ |",
                    "+======+"
            )
    );

    public List<String> get(int errorNumber) {
        return PICTURES.get(errorNumber);
    }
}

