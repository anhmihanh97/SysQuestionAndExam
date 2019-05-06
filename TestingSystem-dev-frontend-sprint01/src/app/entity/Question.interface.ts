import { Category } from './Category.interface';
import { Answer } from './Answer.interface';


export interface Question {
  questionId: string;
  category: Category;
  content: string;
  typeId: number;
  levelId: number;
  sugguestion: string;
  questionTag: number;
  status: number;
  userIdCreated: number;
  dateCreated: Date;
  answers: Answer[];
}
