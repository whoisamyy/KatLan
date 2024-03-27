package org.katarine.compiler.visitors;

import org.katarine.compiler.antlr4.KatLanBaseVisitor;
import org.katarine.compiler.antlr4.KatLanParser;

import java.util.HashMap;

public class KLImportVisitor extends KatLanBaseVisitor<HashMap<String, Object>> {
    @Override
    public HashMap<String, Object> visitImportBlock(KatLanParser.ImportBlockContext ctx) {
        HashMap<String, Object> map = new HashMap<>();

        ctx.importStatement().forEach(is -> {
            if (is.AS_KEYWORD()!=null) {
                map.put(is.NAME(1).getText(), is.NAME(0).getText());
            } else {
                map.put(is.NAME(0).getText(), is.NAME(0).getText());
            }
        });
        return map;
    }
}
