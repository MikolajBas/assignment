package interview.assignment.service;

public enum AttributeName {

    ID("Id"), ACCEPTED_ANSWER_ID("AcceptedAnswerId"), CREATION_DATE("CreationDate"), SCORE("Score"),
    VIEW_COUNT("ViewCount"), LAST_EDIT_DATE("LastEditDate"), LAST_ACTIVITY_DATE("LastActivityDate"),
    TAGS("Tags"), ANSWER_COUNT("AnswerCount"), COMMENT_COUNT("CommentCount");
    private final String value;



    AttributeName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
