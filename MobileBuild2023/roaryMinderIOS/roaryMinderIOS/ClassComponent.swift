//
//  ClassComponent.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/21/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ClassComponent: View {
    let classTitle: String
    let classDescription: String
    let classImage: Image
    let isHomePage: Bool
    @ObservedObject var viewModel: iOSRoaryViewModel
    @State var course: RoaryRepoInfo
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        VStack {
            ZStack {
                VStack {
                    classImage
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                        .frame(height: 120)
                        .clipShape(RoundedRectangle(cornerRadius: 10))
                        .overlay(
                            RoundedRectangle(cornerRadius: 10)
                                .stroke(Color.gray.opacity(0.3), lineWidth: 0)
                                .padding(-1)
                        )
                    
                    VStack(alignment: .leading, spacing: 8) {
                        HStack {
                            Text(classTitle)
                                .font(.headline)
                                .fontWeight(.semibold)
                                .foregroundColor(.primary)
                            
                            Spacer()
                        }
                        
                        Divider()
                            .background(Color.gray.opacity(0.3))
                        
                        HStack{
                            Text(classDescription)
                                .font(.body)
                                .foregroundColor(.gray)
                            
                            Spacer()
                            
                            Button(action: {
                                viewModel.getRepo().deleteQuery(classForRepo: course)
                                self.presentationMode.wrappedValue.dismiss()
                                
                            }) {
                                Image(systemName: "trash.circle.fill")
                                    .foregroundColor(.red)
                                    .font(.title2)
                                
                            }
                        }
                    }
                    .padding([.leading, .trailing])
                    .padding(.bottom, 8)
                }
            }
            .padding(10)
            .background(Color(UIColor.systemBackground))
            .cornerRadius(10)
            .shadow(color: Color.gray.opacity(0.3), radius: 2, x: 0, y: 2)
        }
    }
}






