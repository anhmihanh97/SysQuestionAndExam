import { Test } from "src/app/semester-exam/semester/detail/test-result/test.interface";

export interface TestResult {
   tests: Test;
   correct_number: number;
   mark: number;
   start_time: Date;
   end_time: Date;
   numberOfQuestion: number;
}
