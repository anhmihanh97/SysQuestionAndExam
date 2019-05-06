import { Question } from './Question.interface';

export interface ExamQuestion {
   question: Question;
   choiceOrder: string;
   choiceOrderList: number[];
}
