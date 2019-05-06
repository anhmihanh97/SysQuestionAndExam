import { User } from 'src/entity/User';
import { courseCatalog } from './courseCatalog';
import { chapters } from './chapters';

export class Course {
  courseId: number;
    courseName: string;
    video: string;
    tags: string;
    title: string;
    description: string;
    image: string;
    vote: number;
    price: number;
    status: number;
    users: User[];
    courseCatalog: courseCatalog;
    chapters: chapters[];
}
