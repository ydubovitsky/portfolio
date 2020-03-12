package space.portfolio.service;

public class NameService {

    private NameService() {

    }

    private static NameService nameService;

    public static NameService getInstance() {
        if (nameService == null) {
            nameService = new NameService();
        }
        return nameService;
    }

    public String convertName(String name) {
        return name.toUpperCase();
    }
}
