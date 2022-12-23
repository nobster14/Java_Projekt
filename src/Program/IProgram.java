package Program;

import Loader.ILoader;

public interface IProgram {
    public default void Start(int n) {
        ILoader.Load();
        CreateFamilyContainers(n);
        ExportFamilyContainers();
    }

    default void CreateFamilyContainers(int n) {

    }

    default void ExportFamilyContainers() {

    }
}
