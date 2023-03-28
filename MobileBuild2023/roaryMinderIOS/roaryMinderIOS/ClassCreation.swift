//
//  ClassCreation.swift
//  RoaryMinder
//
//  Created by Camila on 3/23/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ClassCreationView: View {
    @State private var courseName = ""
    @State private var professorName = ""
    
    var body: some View {
        VStack {
            //Course & Professor Name
            
            TextField("Course Name", text: $courseName)
                .padding()
            TextField("Professor Name", text: $professorName)
                .padding()
            
            //Add Class Button
            Button(action: {
            }) {
                Text("Add Class")
                    .foregroundColor(.white)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color.blue)
                    .cornerRadius(10)
            }
            .padding()
        }
        .padding()
        .navigationBarTitle("Class Creation")
    }
    
}
