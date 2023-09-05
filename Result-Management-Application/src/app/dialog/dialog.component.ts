import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { InjectFlags } from '@angular/compiler/src/core';
@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  resultForm !: FormGroup;
  actionBtn: string = "Save"
  constructor(private formBuilder: FormBuilder, private api: ApiService, @Inject(MAT_DIALOG_DATA) public editData: any,
    private dialogref: MatDialogRef<DialogComponent>) { }

  ngOnInit(): void {
    this.resultForm = this.formBuilder.group({
      //  RollNo:['',Validators.required],
      //  Name:['',Validators.required,Validators.minLength(3)],
      //  DOB:['',Validators.required],
      //  Score:['',Validators.required]
      RollNo: new FormControl('', [Validators.required, Validators.min(1),Validators.pattern('[0-9]+$')]),
      Name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      DOB: new FormControl('', [Validators.required]),
      Score: new FormControl('', [Validators.required, Validators.min(1),Validators.max(100), Validators.pattern('[0-9]+$')])


    });
    if (this.editData) {
      this.actionBtn = "Update";
      this.resultForm.controls['RollNo'].setValue(this.editData.RollNo);
      this.resultForm.controls['Name'].setValue(this.editData.Name);
      this.resultForm.controls['DOB'].setValue(this.editData.DOB);
      this.resultForm.controls['Score'].setValue(this.editData.Score);
    }
  }
  addResult() {
    if (!this.editData) {
      if (this.resultForm.valid) {
        this.api.postResult(this.resultForm.value)
          .subscribe({
            next: (res) => {
              alert("Result added Successfullt")
              this.resultForm.reset();
              this.dialogref.close('save');
            },
            error: () => {
              alert("Error in updating Result")
            }
          })
      }
    }
    else {
      this.updateResult()
    }
  }
  updateResult() {
    this.api.putResult(this.resultForm.value, this.editData.id)
      .subscribe({
        next: (res) => {
          alert("Result updated Successfully");
          this.resultForm.reset();
          this.dialogref.close('update');
        },
        error: () => {
          alert("Error in updateing record");
        }
      })
  }
  get score() {
    return this.resultForm.get('Score');
  }
  get name() {
    return this.resultForm.get('Name');
  }
  get rollNo() {
    return this.resultForm.get('RollNo');
  }
}
