public class DeluxeRoomFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(16000.0); }
}
