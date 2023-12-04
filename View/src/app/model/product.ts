import { Category } from "./category";
import { Listas } from "./listas";

export interface Product {
    
    productId: number;
    name: string;
    description: string;
    imgUrl: string;
    price: number;
    lists: Listas[]; 
    category: Category;
}