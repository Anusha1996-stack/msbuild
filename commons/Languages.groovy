package commons

enum Languages implements ILanguages{

    DOT_NET_CORE("dotNetCore", "/unit-test-results", "report.xml", "/code-coverage-results", "CodeCoverage.xml", ""),
    C_SHARP("cSharp", "","","","",""),
    JAVA_MAVEN("javaMaven", "/build/target/surefire-reports/", "", "/build/target/site/jacoco", "jacoco.xml", "/build/target"),
    PYTHON("python", "", "", "", "", ""),
    JS_UI("jsUi", "", "", "", "", "")

    private String languageName
    private String testResultsDirectory
    private String testResultFile
    private String buildArtifactDirectory

    private static Map<String, Languages> languageMap = new HashMap<String, Languages>()

    private Languages(String languageName,
        String testResultsDirectory,
        String testResultFile,
        String buildArtifactDirectory) {
        this.languageName = languageName
        this.testResultsDirectory = testResultsDirectory
        this.testResultFile = testResultFile
        this.buildArtifactDirectory = buildArtifactDirectory
        this.codeCoverageDirectory = codeCoverageDirectory
        this.codeCoverageFile = codeCoverageFile

    }

    public String getLanguageName() {
        return languageName
    }

    public String getTestResultsDirectory() {
        return testResultsDirectory
    }

    public String getTestResultFile() {
        return testResultFile
    }

    public String getBuildArtifactDirectory() {
        return buildArtifactDirectory
    }


    public static Languages getLanguage(String languageNameParam) {
        for(Languages language : Languages.values()) {
            languageMap.put(language.getLanguageName(), language)
        }
        return Languages.GROOVY_GRADLE
    }
}
