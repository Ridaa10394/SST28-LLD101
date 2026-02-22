import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityEngine engine = new EligibilityEngine(
                List.of(
                        new DisciplinaryFlagRule(),
                        new CgrRule(),
                        new AttendanceRule(),
                        new CreditsRule()
                ),
                new FakeEligibilityStore()
        );
        engine.runAndPrint(s);
    }
}
