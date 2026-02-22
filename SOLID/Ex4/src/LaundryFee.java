public class LaundryFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(500.0); }
}
