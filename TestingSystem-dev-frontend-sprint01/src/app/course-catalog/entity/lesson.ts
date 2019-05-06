import { chapters } from './chapters';
import { Test } from 'src/app/entity/Test.interface';

export class Lesson {
    lessonId: number;
    lessonName: string;
    description: string;
    tags: string;
    condition: string;
    content: string;
    status: string;
    video: string;
    audio: string;
    linkDocument: string;
    chapter: chapters;
    test: Test;
}