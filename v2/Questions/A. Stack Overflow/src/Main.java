public class Main {
    public static void main(String[] args) {
        User user = new User("Suraj");
        Question firstQuestion = new Question("Unable to understand Java OOPS concepts", user, "Java");
        UserService userService = new UserService();
        userService.setPostStrategy(new PostQuestion());
        UserTagService userTagService = new UserTagService(user);
        userTagService.addTags(firstQuestion, Tag.JAVA);
        userService.post(user, firstQuestion);
        System.out.println(user.getQuestions());
        System.out.println(user.getReputation());
        UserSearchService userSearchService = new UserSearchService(user);
        userSearchService.setUserSearchStrategy(new UserSearchByKeyword());
        System.out.println(userSearchService.search("Java").size());
    }
}