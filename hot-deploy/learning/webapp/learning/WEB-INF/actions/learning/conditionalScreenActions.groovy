context.put("blah", "blest")
passMsg = "Condition passed. Showing widgets element.<br/>" +
        "Blah is: " + context.get("blah") + "<br/>" +
        "show is: " + parameters.get("show")
context.put("passMsg",passMsg)
