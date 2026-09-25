public record Node(Session first, Node rest) {
    //     (Linked List)
//     an IntList is either:
//     - null, or           (i.e., the empty list)
//     - Node(int, IntList) (i.e., non-empty lists

    public static Session searchByID (Node lst, int id) {
        switch (lst) {
            case null:
                return null;
            case Node(Session f, Node r):
                if (f.getID() == id) {
                    return f;
                } else {
                    return searchByID(r, id);
                }
        }
    }

    public static Node searchByMentor (Node lst, String mentor) {
        switch (lst) {
            case null:
                return null;
            case Node(Session f, Node r):
                if (f.getMentor().equals(mentor)) {
                    return new Node(f, searchByMentor(r, mentor));
                } else {
                    return searchByMentor(r, mentor);
                }
        }
    }

    public static Node insertSession (Node lst, Session toInsert) {
        switch (lst) {
            case null:
                return new Node(toInsert, null);
            case Node(Session first, Node rest):
                if (toInsert.getDate().compareTo(first.getDate()) <= 0) {
                    return new Node(toInsert, lst);
                } else {
                    return new Node(first, insertSession(rest, toInsert));
                }
        }
    }

    public static Node removeByID(Node lst, int id) {
        switch (lst) {
            case null:
                return null;
            case Node(Session f, Node r):
                if (f.getID() == id) {
                    return r;
                } else {
                    return new Node(f, removeByID(r, id));
                }
        }
    }




//    public static boolean contains(Node lst, int val) {
//        switch (lst) {
//            case null:
//                return false;
//            case Node(Session f, Node r):
//                return f == val || contains(r, val);
//
//        }
//    }

    private static String compactStringNoParens(Node lst) {
        switch (lst) {
            case null:
                return "";
            case Node(Session f, Node r):
                if (r == null) {
                    return "" + f;
                } else {
                    return f + " " + compactString(r);
                }
        }
    }

    public static String compactString(Node lst) {

        return "(" + compactStringNoParens(lst) + ")";
//        switch (lst) {
//            case null:
//                return "()";
//            case Node(int f, Node r):
//                if (r == null) {
//                    return "(" + f + ")";
//                } else {
//                    return "(" + f + compactString(r).substring(1);
//                }
//        }
    }


    // returns the third value in the given list
    public static Session getThird(Node lst) {
        switch (lst) {
            case Node(_, Node(_, Node(Session t, _))):
                return t;
            default:
                throw new IllegalArgumentException("length of list < 3");
        }
//        if (lst != null && lst.rest != null && lst.rest.rest != null) {
//            return lst.rest.rest.first;
//        } else {
//            throw new IllegalArgumentException(("bleh"));
//        }
    }



    static void main() {

    }

}