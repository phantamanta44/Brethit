package io.github.phantamanta44.brethit.constant;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum LangConst {

    /**
     * Arsg: weapon name
     */
    TOAST_TOOL_BREAKING("brethit.toast.tool.breaking", TextFormatting.YELLOW),
    /**
     * Args: weapon name
     */
    TOAST_TOOL_BROKE("brethit.toast.tool.broke", TextFormatting.RED),

    TOAST_ENV_COLD("brethit.toast.env.cold", TextFormatting.AQUA),
    TOAST_ENV_HOT("brethit.toast.env.hot", TextFormatting.RED);

    public final String key;
    public final String style;

    LangConst(String key, TextFormatting... style) {
        this.key = key;
        this.style = Arrays.stream(style).map(TextFormatting::toString).collect(Collectors.joining());
    }

    public String resolve(Object... args) {
        return style + raw(args);
    }

    public String raw(Object... args) {
        return String.format(I18n.translateToLocal(key), args);
    }

    public LangStr bind(Object... args) {
        return new LangStr(this, args);
    }

    public static class LangStr implements Supplier<String> {

        private final LangConst key;
        private final Object[] args;

        public LangStr(LangConst key, Object[] args) {
            this.key = key;
            this.args = args;
        }

        @Override
        public String get() {
            return key.resolve(args);
        }

        public String raw() {
            return key.raw(args);
        }

    }

}
