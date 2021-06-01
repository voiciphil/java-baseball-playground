package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual1 = "1".split(",");
        String[] actual2 = "1,2".split(",");
        assertThat(actual1).contains("1");
        assertThat(actual2).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String actual = given.substring(1, given.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String given = "abc";
        assertThat(given.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> given.charAt(given.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
