package dataStructures.Mappers.FileType;

import dataStructures.Config;

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
            case cities -> {
                return Config.citiesPath;
            }
            case streets -> {
                return  Config.streetsPath;
            }
        }
        return null;
    }
}
