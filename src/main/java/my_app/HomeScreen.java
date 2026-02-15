package my_app;

import megalodonte.ComputedState;
import megalodonte.State;
import megalodonte.components.*;
import megalodonte.props.ButtonProps;
import megalodonte.props.ColumnProps;
import megalodonte.props.RowProps;
import megalodonte.props.TextProps;
import megalodonte.styles.ColumnStyler;

public class HomeScreen {
    State<Integer> counter = State.of(0);
    ComputedState<String> counterText = ComputedState.of(()-> "Count: " + counter.get(), counter);

    public Component render() {
        return new Column(new ColumnProps().paddingAll(20), new ColumnStyler().bgColor("#fff"))
                .c_child(new Text(counterText, new TextProps().fontSize(30)))
                .c_child(new SpacerVertical(20))
                .c_child(new Row(new RowProps().spacingOf(10))
                        .r_child((new Button("Decrement", new ButtonProps().onClick(()-> counter.set(counter.get() - 1)))))
                        .r_child(new Button("Incrementar", new ButtonProps().onClick(()-> counter.set(counter.get() + 1)))));
    }
}
