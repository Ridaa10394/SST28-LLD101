import java.util.*;

public class OnboardingService {
    private final InputParser parser;
    private final StuValidator validator;
    private final StuRepo repo;
    private final ConsolePrinter printer;

    public OnboardingService(StuRepo repo) {
        this.repo = repo;
        this.parser = new InputParser();
        this.validator = new StuValidator();
        this.printer = new ConsolePrinter();
    }


    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String, String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> errors = validator.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repo.save(rec);

        printer.printSuccess(id, repo.count(), rec);
    }
}
