import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {
  uploadedImage: File;
  dbImage: any;
  postResponse: any;
  successResponse: string | undefined;
  image: any;
  constructor() { }
 
  ngOnInit(): void {
  }
  public onImageUpload(event:any) {
    this.uploadedImage = event.target.files[0];
  }
  imageUploadAction() {
    const imageFormData = new FormData();
    
    imageFormData.append('image', this.uploadedImage, this.uploadedImage.name);
   console.log(  imageFormData);
    console.log("imageFormDATA");
   console.log( this.uploadedImage);

     
  }
}
