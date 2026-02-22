import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        List<FeeComponent> components = new ArrayList<>();
        components.add(new DoubleRoomFee());
        for (AddOn a : req.addOns) {
            if (a == AddOn.MESS)         components.add(new MessFee());
            else if (a == AddOn.LAUNDRY) components.add(new LaundryFee());
            else if (a == AddOn.GYM)     components.add(new GymFee());
        }

        HostelFeeCalculator calc = new HostelFeeCalculator(components, new FakeBookingRepo());
        calc.process(req);
    }
}
