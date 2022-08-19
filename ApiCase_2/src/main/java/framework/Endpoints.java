package framework;

public class Endpoints {

    public static final String FIND_PETS_BY_STATUS_AVAILABLE = "/pet/findByStatus?status=available";
    public static final String FIND_PETS_BY_STATUS_PENDING = "/pet/findByStatus?status=pending";
    public static final String FIND_PETS_BY_STATUS_SOLD = "/pet/findByStatus?status=sold";
    public static final String FIND_PET_BY_ID = "/pet/{id}";
    public static final String UPDATE_PET_IN_THE_STORE = "/pet/{id}";
    public static final String DELETE_A_PET = "/pet/{id}";
}
