import { Pipe,PipeTransform } from "@angular/core";
import { Pannel } from "../entities/pannel.entity";
@Pipe({
    name:'search'
})

export class SearchText implements PipeTransform{
    transform(pannels: Array<Pannel>, ...args: any[]) {
        let pannelMembersDetails:Array<Pannel>=new Array();
        let SearchText=args[0];
        if(SearchText!='' || SearchText!=''){
            for(let panel of pannels){
                if(panel.type.includes(SearchText)||panel.name.includes(SearchText)){
                    pannelMembersDetails.push(panel);
                }
            }
                return pannelMembersDetails;
        }
            pannelMembersDetails = pannelMembersDetails;
            return pannels;
        
    }
}
