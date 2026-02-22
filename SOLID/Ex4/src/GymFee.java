public class GymFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(300.0); }
}
