package DataStructures.Mappers.FileType;

import DataStructures.Config;

public class FileTypeMapper {
    public static String MapFileTypeToFileName(FileType fileType)
    {
        switch (fileType) {
            case maleNames -> {
                return Config.maleNamesPath;
            }
            case maleSurnames -> {
                return Config.maleSurnamesPath;
            }
            case femaleNames -> {
                return Config.femaleNamesPath;
            }
            case femaleSurnames -> {
                return Config.femaleSurnamesPath;
            }
        }
        return null;
    }
}
