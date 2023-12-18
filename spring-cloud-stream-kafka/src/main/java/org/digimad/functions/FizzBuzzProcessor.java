//package org.digimad.functions;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.function.Function;
//
//@Component("fizzBuzzProcessor")
//@AllArgsConstructor
//@Slf4j
//public class FizzBuzzProcessor implements Function<Flux<Integer>, Flux<String>> {
//
//    @Override
//    public Flux<String> apply(Flux<Integer> integerFlux) {
//        return integerFlux.map(i -> evaluateFizzBuzz(i)).log();
//    }
//
//    private String evaluateFizzBuzz(Integer value) {
//        if (value % 15 == 0) {
//            return "FizzBuzz";
//        } else if (value % 5 == 0) {
//            return "Buzz";
//        } else if (value % 3 == 0) {
//            return "Fizz";
//        } else {
//            return String.valueOf(value);
//        }
//    }
//}
