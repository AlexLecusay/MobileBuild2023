//
//  ClassComponent.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/21/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ClassComponent: View {
    let classTitle: String
    let classDescription: String
    let classImage: Image
    let isHomePage: Bool
    
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
                            
                        }
                        
                        Divider()
                            .background(Color.gray.opacity(0.3))
                        HStack{
                            Text(classDescription)
                                .font(.body)
                                .foregroundColor(.gray)
                            if !isHomePage {
                                Spacer()
                                
                                Button(action: {}) {
                                    Image(systemName: "plus.circle.fill")
                                        .foregroundColor(.blue)
                                        .font(.title2)
                                }
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





struct ClassComponent_Previews: PreviewProvider {
    static var previews: some View {
        ClassComponent(classTitle: "History 101", classDescription: "Learn about ancient civilizations and their impact on modern society.", classImage: Image("sample"),isHomePage: true)

            
    }
}
