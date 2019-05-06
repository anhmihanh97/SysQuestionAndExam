import { Answer } from './Answer.interface';
export interface Question {
   questionId: string;
   content: string;
   answers: Answer[];
}
