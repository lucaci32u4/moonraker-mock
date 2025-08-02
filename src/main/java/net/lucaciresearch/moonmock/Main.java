package net.lucaciresearch.moonmock;

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {



        var app = Javalin.create(config -> {
                })
                .get("/printer/objects/query", ctx -> {
                    String queryString = ctx.queryString();
                    if (queryString != null) {
                        if (queryString.contains("webhooks")) {
                            ctx.contentType("application/json");
                            ctx.result("{\"result\": {\"eventtime\": 3667765.836021322, \"status\": {\"webhooks\": {\"state\": \"shutdown\", \"state_message\": \"Printer is offline or not reacheable on network\\nOnce the underlying issue is corrected, use the refresh button on the browser\\nto reload the page.\\nPrinter is offline\\n\"}}}}");
                        }

                        if (queryString.contains("display_status")) {
                            ctx.contentType("application/json");
                            ctx.result("{\"result\": {\"eventtime\": 3671426.550685492, \"status\": {\"display_status\": {\"progress\": 1.0, \"message\": null}}}}");
                        }

                        if (queryString.contains("print_stats")) {
                            ctx.contentType("application/json");
                            ctx.result("{\"result\": {\"eventtime\": 3671482.253441959, \"status\": {\"print_stats\": {\"filename\": \"Fulie gobilda buna v2.gcode\", \"total_duration\": 2932.3419803269207, \"print_duration\": 2724.4853332838975, \"filament_used\": 5873.117489999804, \"state\": \"complete\", \"message\": \"\", \"info\": {\"total_layer\": 50, \"current_layer\": 49}}}}}");
                        }
                    }
                })
                .get("/", ctx -> ctx.result("OK"))
                .start(7125);

    }

}
