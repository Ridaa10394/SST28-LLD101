public class SingleRoomFee implements FeeComponent {
    @Override
    public Money monthlyContribution() { return new Money(14000.0); }
}
