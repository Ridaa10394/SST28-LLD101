public class TripleRoomFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(12000.0); }
}
