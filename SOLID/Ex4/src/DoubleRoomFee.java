public class DoubleRoomFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(15000.0); }
}
