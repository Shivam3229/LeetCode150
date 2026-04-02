class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String parts[] = path.split("/");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("") || parts[i].equals(".")) 
            // the current directory
            {
                continue;
            } else if (parts[i].equals("..")) {
                // the previous directory initialize and the current gets removed
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(parts[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/" + stack.get(i));
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
